package com.tx.Manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;

@SpringBootApplication
@EnableTransactionManagerServer
public class TxManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(TxManagerApplication.class, args);
	}
}
