package com.gridpoint.energy.util.collection;

public class SimpleDifferFactory
{
    public static SimpleDiffer buildDomainDiffer(final Class domainType)
    {
        final SimpleDiffer entityDiffer = new SimpleDiffer();
        entityDiffer.setEqualsnessResolutionStrategy(new WrittenDateEqualsnessResolutionStrategy());
        entityDiffer.setDescentLimited(true);
        entityDiffer.addDeepPropertyNameNotToIgnore("id");

            /*
            There is an informal, little-documented convention that update methods in the Public API ignore non-ID
            properties of nested object properties that need to be mapped to JPA entity objects.

            A good example of this is Firmware.EndpointType. If you invoke
            EndpointService.updateFirmware(Firmware, ...), it won't matter what you put for
            firmware.endpointType.name or firmware.endpointType.description. The only property that will get looked
            at is firmware.endpointType.endpointTypeId. This is a consequence of the fact that we are using the same
            domain objects for output and input, even though these operations aren't really symmetric.

            SimpleDiffer has no way to know whether any particular nested object property will ultimately be mapped
            to a JPA Entity. Most are, so it guesses by default that any particular nested object property will be.
            Consequently, its default behavior is to ignore non-ID properties of nested Object properties.

            This is inappropriate for some use cases, notably UserDetails.UserAuthorities. Accordingly, we override
            the default behavior here as needed, below.
            */


        if (domainType!=null)
        {
            final String simpleDomainTypeName = domainType.getSimpleName();

            if ("Firmware".equals(simpleDomainTypeName))
            {
                entityDiffer.addDeepPropertyNameNotToIgnore("endpointTypeId");
            }
            else if ("UserDetails".equals(simpleDomainTypeName))
            {
                entityDiffer.addShallowPropertyNameToIgnore("resetPassword");
                entityDiffer.addShallowPropertyNameToIgnore("defaultTenant");
                entityDiffer.addShallowPropertyNameToIgnore("password");
                entityDiffer.addDeepPropertyNameNotToIgnore("capabilities");
                entityDiffer.addDeepPropertyNameNotToIgnore("accessMap");
            }

            // ...
        }

        return entityDiffer;
    }
}
