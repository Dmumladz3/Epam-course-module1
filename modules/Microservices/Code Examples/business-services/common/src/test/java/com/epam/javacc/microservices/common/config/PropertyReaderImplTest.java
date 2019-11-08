package com.epam.javacc.microservices.common.config;

import com.epam.javacc.microservices.config.PropertyReaderImpl;
import org.junit.Assert;
import org.junit.Test;

public class PropertyReaderImplTest {

    @Test(expected = RuntimeException.class)
    public void testLoadConfigFail() {
        new PropertyReaderImpl("unrealfile");
    }

    @Test
    public void testReadString() {
        PropertyReaderImpl propertyReader = new PropertyReaderImpl("archaius-test");
        Assert.assertEquals("Hello World", propertyReader.getStringProperty("helloString"));
        Assert.assertEquals(PropertyReaderImpl.UNDEFINED_STRING_PROPERTY, propertyReader.getStringProperty("undefined"));
        Assert.assertEquals(PropertyReaderImpl.UNDEFINED_STRING_PROPERTY, propertyReader.getStringProperty(""));
        Assert.assertEquals(PropertyReaderImpl.UNDEFINED_STRING_PROPERTY, propertyReader.getStringProperty(null));
    }

    @Test
    public void testReadInt() {
        PropertyReaderImpl propertyReader = new PropertyReaderImpl("archaius-test");
        Assert.assertEquals(10, propertyReader.getIntProperty("testInt"));
        Assert.assertEquals(PropertyReaderImpl.UNDEFINED_INT_PROPERTY, propertyReader.getIntProperty("notexists"));
        Assert.assertEquals(PropertyReaderImpl.UNDEFINED_INT_PROPERTY, propertyReader.getIntProperty(""));
        Assert.assertEquals(PropertyReaderImpl.UNDEFINED_INT_PROPERTY, propertyReader.getIntProperty(null));
    }

}
