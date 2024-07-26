package edu.icet.crm.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String status;
    private String errorMessage;
}
