package dev.gabriel.idempotent_payment_gateway.model.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionResponseDto(
        UUID transactionId,
        String status,
        BigDecimal newBalance,
        String message
) {}
//status	message
//SUCCESS	Transfer completed successfully
//FAILED	Insufficient account balance
//PENDING	Transaction is being processedl
//transactionId	Which transaction?
//status	What is the result?
//newBalance	What is the balance after the transaction?
//message	What happened?