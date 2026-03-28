package lk.ijse.documentproofservice.controller;
import jakarta.validation.Valid;
import lk.ijse.documentproofservice.dto.DeliveryProofDTO;
import lk.ijse.documentproofservice.dto.ResponseDTO;
import lk.ijse.documentproofservice.service.DeliveryProofService;
import lk.ijse.documentproofservice.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/proof")
@CrossOrigin
public class DeliveryProofController {

    @Autowired
    private DeliveryProofService service;

    @PostMapping
    public ResponseEntity<ResponseDTO> uploadProof(
            @RequestBody @Valid DeliveryProofDTO dto) {

        int res = service.saveProof(dto);

        if (res == VarList.Created) {
            return ResponseEntity.ok(
                    new ResponseDTO(VarList.Created, "Success", null)
            );
        } else {
            return ResponseEntity.status(500).body(
                    new ResponseDTO(res, "Error", null)
            );
        }
    }

    @GetMapping("/{orderCode}")
    public ResponseEntity<ResponseDTO> getProof(
            @PathVariable String orderCode) {

        Object data = service.getByOrderCode(orderCode);

        if (data instanceof Integer && (int) data == VarList.Not_Found) {
            return ResponseEntity.status(404).body(
                    new ResponseDTO(VarList.Not_Found, "Not Found", null)
            );
        } else if (data instanceof Integer && (int) data == VarList.Internal_Server_Error) {
            return ResponseEntity.status(500).body(
                    new ResponseDTO(VarList.Internal_Server_Error, "Error", null)
            );
        } else {
            return ResponseEntity.ok(
                    new ResponseDTO(VarList.OK, "Success", data)
            );
        }
    }
}