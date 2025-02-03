package org.example.store.member.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.example.store.member.constant.MemberStatus;
import org.example.store.member.constant.Role;
import org.example.store.member.entity.Member;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.Multipart;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class MemberDto {

    private String userId;
    private String userPw;
    private String userName;
    private String userProfile;
    private String userEmail;
    private String addr01;
    private String addr02;
    private String zipcode;
    private String tel;
    private Role role;
    private LocalDateTime regDate;
    private String introduce;
    private MemberStatus status; // 회원 상태 (ACTIVE, DELETED)
    private int followCount;
    private boolean followState;


    private List<FaqDto> faqDtoList;

    private List<ChatDto> chatDtoList;

    private List<ChatRoomDto> chatRoomDtoList;

    private List<ProductDto> productDtoList;

    private List<FollowDto> followDtoList;

    private List<LikeProductDto> likeProductDtoList;



    private List<ReviewDto> reviewDtoList;

    private List<PaymentDto> paymentDtoList;

    @Builder
    public MemberDto(String userId, String userPw, String userName, String userProfile,
                     String userEmail, String addr01, String addr02, String zipcode, Role role, String tel, LocalDateTime regDate,
                     String introduce, MemberStatus status, int followCount, boolean followState,
                     List<FaqDto> faqDtoList, List<ChatDto> chatDtoList,
                     List<ChatRoomDto> chatRoomDtoList, List<ProductDto> productDtoList,
                     List<LikeProductDto> likeProductDtoList, List<FollowDto> followDtoList,
                     List<ReviewDto> reviewDtoList, List<PaymentDto> paymentDtoList) {
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userProfile = userProfile;
        this.userEmail = userEmail;
        this.addr01 = addr01;
        this.addr02 = addr02;
        this.zipcode = zipcode;
        this.tel = tel;
        this.role = role;
        this.regDate = regDate;
        this.introduce = introduce;
        this.status = status != null ? status : MemberStatus.STATUS_ACTIVE;  // 기본 값 설정
        this.followCount = followCount;
        this.followState = followState;

        this.faqDtoList = faqDtoList;
        this.chatDtoList = chatDtoList;
        this.chatRoomDtoList = chatRoomDtoList;
        this.productDtoList = productDtoList;
        this.likeProductDtoList = likeProductDtoList;
        this.followDtoList = followDtoList;
        this.reviewDtoList = reviewDtoList;
        this.paymentDtoList = paymentDtoList;
    }

    public static Member toEntity(MemberDto memberDto, BCryptPasswordEncoder bCryptPasswordEncoder) {

        return Member.builder()
                .userId(memberDto.getUserId())
                .userPw(bCryptPasswordEncoder.encode(memberDto.getUserPw())) // 암호화된 패스워드 저장
                .userName(memberDto.getUserName())
                .userProfile(memberDto.getUserProfile()) // 프로필 경로 그대로 사용
                .userEmail(memberDto.getUserEmail())
                .addr01(memberDto.getAddr01())
                .addr02(memberDto.getAddr02())
                .zipcode(memberDto.getZipcode())
                .tel(memberDto.getTel())
                .introduce(memberDto.getIntroduce())
                .role(Role.ROLE_USER)
                .regDate(memberDto.getRegDate())
                .status(memberDto.getStatus() != null ? memberDto.getStatus() : MemberStatus.STATUS_ACTIVE)

                .productList(ProductDto.toEntityList(memberDto.getProductDtoList()))
                .faqList(FaqDto.toEntityList(memberDto.getFaqDtoList()))
                .chatList(ChatDto.toEntityList(memberDto.getChatDtoList()))
                .chatRoomList(ChatRoomDto.toEntityList(memberDto.getChatRoomDtoList()))
                .likeProductList(LikeProductDto.toEntityList(memberDto.getLikeProductDtoList()))
                .paymentList(PaymentDto.toEntityList(memberDto.getPaymentDtoList()))
                .followList(FollowDto.toEntityList(memberDto.getFollowDtoList()))
                .reviewList(Review.toEntityList(memberDto.getReviewDtoList()))
                .build();
    }

}
