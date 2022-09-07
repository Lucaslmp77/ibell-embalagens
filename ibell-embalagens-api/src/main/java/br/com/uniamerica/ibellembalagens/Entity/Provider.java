package br.com.uniamerica.ibellembalagens.Entity;

import java.time.LocalDateTime;

public class Provider {

    private String name;
    private String cnpjCpf;
    private String phoneNumber;
    private String addres;
    private String email;
    private LocalDateTime dateRegister;
    public String observation;

    public Provider(String name, String cnpjCpf, String phoneNumber, String addres, String email, LocalDateTime dateRegister){
        this.name = name;
        this.cnpjCpf = cnpjCpf;
        this.phoneNumber = phoneNumber;
        this.addres = addres;
        this.email = email;
        this.dateRegister = dateRegister;
    }

    public Provider(){}

    public Provider(String name, String cnpjCpf, String phoneNumber, String addres, String email, LocalDateTime dateRegister, String observation){
        this.name = name;
        this.cnpjCpf = cnpjCpf;
        this.phoneNumber = phoneNumber;
        this.addres = addres;
        this.email = email;
        this.dateRegister = dateRegister;
        this.observation = observation;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name= name;
    }

    public String getCnpjCpf(){
        return this.cnpjCpf;
    }
    public void setCnpjCpf(String cnpjCpf){
        this.cnpjCpf = cnpjCpf;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getAddres(){
        return this.addres;
    }
    public void setAddres(String addres){
        this.addres = addres;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public LocalDateTime getDateRegister(){
        return this.dateRegister;
    }
    public void setDateRegister(LocalDateTime dateRegister){
        this.dateRegister = dateRegister;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "name='" + name + '\'' +
                ", cnpjCpf='" + cnpjCpf + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addres='" + addres + '\'' +
                ", email='" + email + '\'' +
                ", dateRegister=" + dateRegister +
                ", observation='" + observation + '\'' +
                '}';
    }

}
