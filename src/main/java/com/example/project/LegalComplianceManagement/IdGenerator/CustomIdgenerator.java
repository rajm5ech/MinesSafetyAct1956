package com.example.project.LegalComplianceManagement.IdGenerator;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;


@SuppressWarnings("serial")
public class CustomIdgenerator implements IdentifierGenerator
{
   @Override
   public Serializable generate(SharedSessionContractImplementor session, Object obj) {
       return  String.format("%03d", UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
   }
}
