package com.luboblog.customer.service.command;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.luboblog.customer.command.CreateAccountCommand;
import com.luboblog.customer.command.CreditMoneyCommand;
import com.luboblog.customer.command.DebitMoneyCommand;
import com.luboblog.customer.dto.commands.AccountCreateDTO;
import com.luboblog.customer.dto.commands.MoneyCreditDTO;
import com.luboblog.customer.dto.commands.MoneyDebitDTO;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
public class AccountCommandServiceImpl implements AccountCommandService {
    private final CommandGateway commandGateway;

    public AccountCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO) {
        return commandGateway.send(new CreateAccountCommand(UUID.randomUUID().toString(), accountCreateDTO.getStartingBalance(), accountCreateDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO) {
        return commandGateway.send(new CreditMoneyCommand(accountNumber, moneyCreditDTO.getCreditAmount(), moneyCreditDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO) {
        return commandGateway.send(new DebitMoneyCommand(accountNumber, moneyDebitDTO.getDebitAmount(), moneyDebitDTO.getCurrency()));
    }
}