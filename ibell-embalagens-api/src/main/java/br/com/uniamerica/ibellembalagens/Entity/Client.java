package br.com.uniamerica.ibellembalagens.Entity;

import java.time.LocalDateTime;

public class Client extends AbstractEntity {
    private Long id;
    private String name;
    private String cpf;
    private String phoneNumber;
    private String address;
    private LocalDateTime registrationDate;
    private String observation;

    public Client() {
    }

    public Client(Long id,String name, String cpf, String phoneNumber, String address, LocalDateTime registrationDate, String observation) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.registrationDate = registrationDate;
        this.observation = observation;
    }

    public Client(String name, String cpf, String phoneNumber, String address, LocalDateTime registrationDate) {
        this.name = name;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getObservacao() {
        return observation;
    }

    public void setObservacao(String observation) {
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", registrationDate=" + registrationDate +
                ", observation='" + observation + '\'' +
                '}';
    }
}
