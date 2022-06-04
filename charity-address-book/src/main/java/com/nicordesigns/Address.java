package com.nicordesigns;

import java.time.Instant;
import java.time.MonthDay;

public class Address implements Comparable<Address>
{
    private String charityId;

    private String charityName;

    private String phoneNumber;

    private String webAddress;

    private MonthDay registrationday;

    private Instant dateCreated;

    public Address(String firstName, String lastName, String phoneNumber,
                   String address, MonthDay registrationday,
                   Instant dateCreated)
    {
        this.charityId = firstName;
        this.charityName = lastName;
        this.phoneNumber = phoneNumber;
        this.webAddress = address;
        this.setRegistrationday(registrationday);
        this.dateCreated = dateCreated;
    }

    public String getFirstName()
    {
        return charityId;
    }

    public void setFirstName(String firstName)
    {
        this.charityId = firstName;
    }

    public String getLastName()
    {
        return charityName;
    }

    public void setLastName(String lastName)
    {
        this.charityName = lastName;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress()
    {
        return webAddress;
    }

    public void setAddress(String address)
    {
        this.webAddress = address;
    }

    
    public Instant getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(Instant dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    @Override
    public int compareTo(Address other)
    {
        int last = charityName.compareTo(other.charityName);
        if(last == 0)
            return charityId.compareTo(other.charityId);
        return last;
    }

	public MonthDay getRegistrationday() {
		return registrationday;
	}

	public void setRegistrationday(MonthDay registrationday) {
		this.registrationday = registrationday;
	}
}
