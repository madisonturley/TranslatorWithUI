package edu.bsu.cs222;

import org.junit.Assert;
import org.junit.Test;

public class IdentityTranslatorTest {

    @Test
    public void testTranslate_noChange(){
        final IdentityTranslator translator = new IdentityTranslator();
        final String input = "Foo";
        final String output = translator.translate(input);
        Assert.assertEquals(input, output);
    }

    @Test
    public void testTranslate_noChangeOfEmptyString(){
        final IdentityTranslator translator = new IdentityTranslator();
        final String input = "";
        final String output = translator.translate(input);
        Assert.assertEquals(input, output);
    }

}
