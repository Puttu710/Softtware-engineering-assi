package com.cleancoder.args;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.cleancoder.args.ArgsException.ErrorCode.MISSING_STRING;

public class StringArgumentMarshaler implements ArgumentMarshaler {
  private String stringValue = "";

  public void set(Iterator<String> currentArgument) throws ArgsException {
    try {
      stringValue = currentArgument.next();
    } 
    catch (NoSuchElementException e) {
      throw new ArgsException(MISSING_STRING);
    }
  }

  public boolean instanceStringArgument(ArgumentMarshaler am){
    if(am != null)
      if(am instanceof StringArgumentMarshaler)
        return true;
      else
        return false;
  }

  public static String getValue(ArgumentMarshaler am) {
    if (instanceStringArgument(am))
      return ((StringArgumentMarshaler) am).stringValue;
    else
      return "";
  }
}
