package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.exceptions.AccountException;
import com.workintech.s18d4.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account find(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new AccountException("Account with given id does not exist " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account delete(Long id) {
        Account toBeDeleted = find(id);
        accountRepository.delete(toBeDeleted);
        return toBeDeleted;
    }
}
