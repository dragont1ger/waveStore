package org.example.store.product.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.store_project.chatRoom.ChatRoom;
import org.example.store_project.like_product.LikeProduct;
import org.example.store_project.member.Member;
import org.example.store_project.memberReview.Review;
import org.example.store_project.payment.Payment;
import org.example.store_project.product.dto.ProductDto;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int productId;

    @NotNull
    private String productName;

    @NotNull
    private String description;

    @NotNull
    private int price;

    @NotNull
    private String thumbnailUrl;

    @NotNull
    private String productStatus; //상품상태

    private int views;

    private String tag;

    private String category;

    private boolean sellStatus; //판매상태

    private boolean display; //숨김 기능 구현

    @CreatedDate
    @LastModifiedDate
    private LocalDateTime postDate;


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member seller;

    @OneToOne(mappedBy = "product")
    private ChatRoom chatRoom;

    @OneToMany(mappedBy = "product")
    List<LikeProduct> likeList;

    @OneToOne(mappedBy = "product")
    private Review review;

    @OneToOne(mappedBy = "product")
    private Payment payment;

    @OneToOne(mappedBy = "product")
    private Image image;

    @Builder
    public Product(int productId, int views, int price, boolean sellStatus, boolean display,
                   String productName, String description, String tag, String category,
                   String productStatus, LocalDateTime postDate, String thumbnailUrl,
                   Member seller, ChatRoom chatRoom, List<LikeProduct> likeList,
                   Review review, Payment payment, Image image) {
        this.productId = productId;
        this.views = views;
        this.price = price;
        this.productName = productName;
        this.description = description;
        this.tag = tag;
        this.category = category;
        this.productStatus = productStatus;
        this.postDate = postDate;
        this.thumbnailUrl = thumbnailUrl;
        this.sellStatus = sellStatus;
        this.display = display;

        this.seller = seller;
        this.chatRoom = chatRoom;
        this.likeList = likeList;
        this.review = review;
        this.payment = payment;
        this.image = image;
    }

    public static ProductDto fromEntity(Product product) {
        return ProductDto.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .description(product.getDescription())
                .price(product.getPrice())
                .thumbnailUrl(product.getThumbnailUrl())
                .productStatus(product.getProductStatus())
                .tag(product.getTag())
                .category(product.getCategory())
                .views(product.getViews())
                .postDate(product.getPostDate())
                .display(product.isDisplay())
                .sellStatus(product.isSellStatus())

                .imageDto(Image.fromEntity(product.getImage()))

                .seller(Member.fromEntity(product.getSeller()))
                .reviewDto(Review.fromEntity(product.getReview()))
                .paymentDto(Payment.fromEntity(product.getPayment()))
                .chatRoomDto(ChatRoom.fromEntity(product.getChatRoom()))
                .likeDtoList(LikeProduct.fromEntityList(product.getLikeList()))
                .build();
    }

    public static List<ProductDto> fromEntityList(List<Product> productList) {
        List<ProductDto> productDtoList = new ArrayList<>();
        productList.forEach(product -> productDtoList.add(fromEntity(product)));
        return productDtoList;
    }
}
