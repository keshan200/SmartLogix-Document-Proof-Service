package lk.ijse.documentproofservice.entity;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "delivery_proofs")
public class DeliveryProof {

    @Id
    private String id;

    @NotBlank(message = "Order code is required")
    private String orderCode;

    @NotBlank(message = "File URL is required")
    @Pattern(
        regexp = "^(http|https)://.*$",
        message = "File URL must be a valid URL"
    )
    private String fileUrl;

    @NotNull(message = "UploadedBy (User ID) is required")
    private Long uploadedBy;

    @NotBlank(message = "Receiver name is required")
    @Size(min = 2, max = 100, message = "Receiver name must be between 2 and 100 characters")
    private String receivedBy;

    @NotBlank(message = "Signature image URL is required")
    @Pattern(
        regexp = "^(http|https)://.*$",
        message = "Signature image must be a valid URL"
    )
    private String signatureImage;

    private LocalDateTime uploadedAt;
}