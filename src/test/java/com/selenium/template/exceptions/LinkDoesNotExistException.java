package com.selenium.template.exceptions;

import org.testng.Assert;

/**
 * Created by azaharia on 04.09.2018.
 */
public class LinkDoesNotExistException extends Exception {
    public LinkDoesNotExistException() {
        Assert.fail("Link Does Not Exist!");
    }
}
