package lk.ijse.documentproofservice.dto;

import lombok.Data;

@Data
public class DeliveryProofDTO {

    private String orderCode;
    private String fileUrl;
    private Long uploadedBy;
    private String receivedBy;
    private String signatureImage;
}