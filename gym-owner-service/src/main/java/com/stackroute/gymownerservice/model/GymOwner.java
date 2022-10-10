package com.stackroute.gymownerservice.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName ="gymvilla",shards = 2,createIndex = true)

public class GymOwner {

    @Id
    private Integer gymId;
    private String gymName;
    private String gymOwnerName;
    private String emailId;
    private String address;
    private long pinCode;
    private long contactNumber;
    private enum check {Available, NotAvailable};
    private check gymSlotStatus;
    public GymOwner() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "GymOwner{" +
                "gymId=" + gymId +
                ", gymName='" + gymName + '\'' +
                ", gymOwnerName='" + gymOwnerName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", address='" + address + '\'' +
                ", pinCode=" + pinCode +
                ", contactNumber=" + contactNumber +
                ", gymSlotStatus=" + gymSlotStatus +
                '}';
    }

    public GymOwner(Integer gymId, String gymName, String gymOwnerName, String emailId, String address, long pinCode, long contactNumber, check gymSlotStatus)
    {
        this.gymId = gymId;
        this.gymName = gymName;
        this.gymOwnerName = gymOwnerName;
        this.emailId = emailId;
        this.address = address;
        this.pinCode = pinCode;
        this.contactNumber = contactNumber;
        this.gymSlotStatus = gymSlotStatus;
    }

    public Integer getGymId() {
        return gymId;
    }

    public void setGymId(Integer gymId) {
        this.gymId = gymId;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getGymOwnerName() {
        return gymOwnerName;
    }

    public void setGymOwnerName(String gymOwnerName) {
        this.gymOwnerName = gymOwnerName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPinCode() {
        return pinCode;
    }

    public void setPinCode(long pinCode) {
        this.pinCode = pinCode;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public check getGymSlotStatus() {
        return gymSlotStatus;
    }

    public void setGymSlotStatus(check gymSlotStatus) {
        this.gymSlotStatus = gymSlotStatus;
    }
}





