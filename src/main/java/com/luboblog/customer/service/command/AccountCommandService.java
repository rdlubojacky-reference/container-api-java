package com.luboblog.customer.service.command;

import java.util.concurrent.CompletableFuture;

import com.luboblog.customer.dto.commands.AccountCreateDTO;
import com.luboblog.customer.dto.commands.MoneyCreditDTO;
import com.luboblog.customer.dto.commands.MoneyDebitDTO;

public interface AccountCommandService {
    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);
}