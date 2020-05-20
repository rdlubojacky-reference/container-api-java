package com.luboblog.account.services.commands;

import java.util.concurrent.CompletableFuture;

import com.luboblog.account.dto.commands.AccountCreateDTO;
import com.luboblog.account.dto.commands.MoneyCreditDTO;
import com.luboblog.account.dto.commands.MoneyDebitDTO;

public interface AccountCommandService {
    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);
}