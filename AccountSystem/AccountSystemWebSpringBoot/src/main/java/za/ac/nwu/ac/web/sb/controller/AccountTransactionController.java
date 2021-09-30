package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.ModifyAccountTransactionFlow;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {

    private final CreateAccountTransactionFlow createAccountTransactionFlow;
    private final FetchAccountTransactionFlow fetchAccountTransactionFlow;
    private final ModifyAccountTransactionFlow modifyAccountTransactionFlow;

    @Autowired
    public AccountTransactionController(@Qualifier("createAccountTransactionFlowName") CreateAccountTransactionFlow createAccountTransactionFlow, FetchAccountTransactionFlow fetchAccountTransactionFlow, ModifyAccountTransactionFlow modifyAccountTransactionFlow) {
        this.createAccountTransactionFlow = createAccountTransactionFlow;
        this.fetchAccountTransactionFlow = fetchAccountTransactionFlow;
        this.modifyAccountTransactionFlow = modifyAccountTransactionFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountTransaction.", notes = "Creates a new AccountTransaction in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountTransaction was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
            @ApiParam(value = "Request body to create a new AccountTransaction.",
                    required = true)
            @RequestBody AccountTransactionDto AccountTransaction) {
        AccountTransactionDto AccountTransactionResponse = createAccountTransactionFlow.create(AccountTransaction);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/T/{transactionId}")
    @ApiOperation(value = "Fetches the specified AccountTransaction.", notes = "Fetches the AccountTransaction corresponding to the given transactionId.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "AccountTransaction found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAccountTransaction(
            @ApiParam(value = "The transactionId that uniquely identifies the AccountTransaction.",
                    example = "4",
                    name = "transactionId",
                    required = true)
            @PathVariable("transactionId") final Long transactionId) {

        AccountTransactionDto AccountTransaction = fetchAccountTransactionFlow.getAccountTransactionById(transactionId);

        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransaction);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("M/{memberId}")
    @ApiOperation(value = "Fetches the specified Member and their miles.", notes = "Fetches the miles corresponding to the given memberId.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Member found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getMember(
            @ApiParam(value = "The memberId that uniquely identifies the member account.",
                    example = "4",
                    name = "memberId",
                    required = true)
            @PathVariable("memberId") final Long memberId) {

        AccountTransactionDto AccountTransaction = fetchAccountTransactionFlow.getAccountTransactionByMemberId(memberId);

        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, AccountTransaction);

        return new ResponseEntity(response, HttpStatus.OK);
    }




    @PutMapping("ADD/MilesToAdd")
    @ApiOperation(value = "Adds Miles to a member.", notes = "Adds miles to the corresponding member's amount.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Miles added"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> addMiles(
            @ApiParam(value = "The memberId that uniquely identifies the account.",
                    example = "23",
                    name = "memberId",
                    required = true)
            @RequestParam("memberId") final Long memberId,

            @ApiParam(value = "The amount to be added.",
                    example = "200",
                    name = "MilesToAdd",
                    required = true)
            @RequestParam("MilesToAdd") final Long MilesToAdd,

            @ApiParam(value = "The optional new transaction date in ISO date format (yyyy-MM-dd)\r\n,",
                    name = "newTransactionDate")
            @RequestParam(value = "newTransactionDate",required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate newTransactionDate,

            @ApiParam(value = "Select true for optional exception.",
                    example = "true",
                    name = "optionalException",
                    required = true)
            @RequestParam("optionalException") final boolean optionalException
    ){
        AccountTransactionDto accountTransaction = modifyAccountTransactionFlow.addMiles(memberId, MilesToAdd,newTransactionDate, optionalException);

        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransaction);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("SUBTRACT/MilesToSubtract")
    @ApiOperation(value = "Subtracts Miles from a member.", notes = "Subtracts miles to the corresponding member's amount.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Miles Subtracted"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> subtractMiles(
            @ApiParam(value = "The memberId that uniquely identifies the account.",
                    example = "23",
                    name = "memberId",
                    required = true)
            @RequestParam("memberId") final Long memberId,

            @ApiParam(value = "The amount to be subtracted.",
                    example = "200",
                    name = "MilesToSubtract",
                    required = true)
            @RequestParam("MilesToSubtract") final Long MilesToSubtract,

            @ApiParam(value = "The optional new transaction date in ISO date format (yyyy-MM-dd)\r\n,",
                    name = "newTransactionDate")
            @RequestParam(value = "newTransactionDate",required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate newTransactionDate
    ){
        AccountTransactionDto accountTransaction = modifyAccountTransactionFlow.subtractMiles(memberId, MilesToSubtract,newTransactionDate);

        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTransaction);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
