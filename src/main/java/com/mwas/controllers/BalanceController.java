package com.mwas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mwas.model.AccountTransactions;
import com.mwas.model.Customer;
import com.mwas.repository.AccountTransactionsRepository;

@RestController
public class BalanceController {

    private final AccountTransactionsRepository accountTransactionsRepository;

    BalanceController(AccountTransactionsRepository accountTransactionsRepository){
        this.accountTransactionsRepository = accountTransactionsRepository;
    }

    @PostMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestBody Customer customer) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.
                findByCustomerIdOrderByTransactionDtDesc(customer.getId());
        if (accountTransactions != null ) {
            return accountTransactions;
        }else {
            return null;
        }
    }
}