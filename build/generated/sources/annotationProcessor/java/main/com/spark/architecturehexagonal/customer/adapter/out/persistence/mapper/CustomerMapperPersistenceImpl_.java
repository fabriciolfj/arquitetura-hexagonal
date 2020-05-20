package com.spark.architecturehexagonal.customer.adapter.out.persistence.mapper;

import com.spark.architecturehexagonal.customer.adapter.out.persistence.entity.AddressEntity;
import com.spark.architecturehexagonal.customer.adapter.out.persistence.entity.CustomerEntity;
import com.spark.architecturehexagonal.customer.domain.Address;
import com.spark.architecturehexagonal.customer.domain.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-19T23:42:31-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 14.0.1 (Private Build)"
)
@Component
@Qualifier("delegate")
public class CustomerMapperPersistenceImpl_ implements CustomerMapperPersistence {

    @Override
    public CustomerEntity toEntity(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setName( customer.getName() );
        customerEntity.setUuid( customer.getUuid() );
        customerEntity.setDocument( customer.getDocument() );
        customerEntity.setId( customer.getId() );
        customerEntity.setAddresses( addressListToAddressEntityList( customer.getAddresses() ) );

        return customerEntity;
    }

    @Override
    public Customer toDomain(CustomerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( entity.getName() );
        customer.setUuid( entity.getUuid() );
        customer.setDocument( entity.getDocument() );
        customer.setId( entity.getId() );
        customer.setAddresses( addressEntityListToAddressList( entity.getAddresses() ) );

        return customer;
    }

    protected AddressEntity addressToAddressEntity(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setId( address.getId() );
        addressEntity.setDescribe( address.getDescribe() );

        return addressEntity;
    }

    protected List<AddressEntity> addressListToAddressEntityList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressEntity> list1 = new ArrayList<AddressEntity>( list.size() );
        for ( Address address : list ) {
            list1.add( addressToAddressEntity( address ) );
        }

        return list1;
    }

    protected Address addressEntityToAddress(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressEntity.getId() );
        address.setDescribe( addressEntity.getDescribe() );

        return address;
    }

    protected List<Address> addressEntityListToAddressList(List<AddressEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        for ( AddressEntity addressEntity : list ) {
            list1.add( addressEntityToAddress( addressEntity ) );
        }

        return list1;
    }
}
