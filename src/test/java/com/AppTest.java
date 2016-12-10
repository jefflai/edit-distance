package com;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    @Test
    public void sameString() {
        Assert.assertEquals(false, App.hasOneChange("hello", "hello"));
    }

    @Test
    public void oneEmptyStringOneLetter() {
        Assert.assertEquals(true, App.hasOneChange("x", ""));
    }

    @Test
    public void twoEmptyStrings() {
        Assert.assertEquals(false, App.hasOneChange("", ""));
    }

    @Test
    public void twoNullStrings() {
        Assert.assertEquals(false, App.hasOneChange(null, null));
    }

    @Test
    public void oneInsertion() {
        Assert.assertEquals(true, App.hasOneChange("hello", "hellos"));
    }

    @Test
    public void oneSubstituion() {
        Assert.assertEquals(true, App.hasOneChange("hello", "bello"));
    }

    @Test
    public void oneDeletion() {
        Assert.assertEquals(true, App.hasOneChange("hllo", "hello"));
    }

    @Test
    public void twoInsertions() {
        Assert.assertEquals(false, App.hasOneChange("hellooo", "hello"));
    }

    @Test
    public void twoSubstitions() {
        Assert.assertEquals(false, App.hasOneChange("heiio", "hello"));
    }

    @Test
    public void twoDeletions() {
        Assert.assertEquals(false, App.hasOneChange("hel", "hello"));
    }

}
