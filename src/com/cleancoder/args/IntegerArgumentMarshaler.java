package com.cleancoder.args;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

import java.util.*;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {
  private int intValue = 0;

  public void set(Iterator<String> currentArgument) throws ArgsException {
    String parameter = null;
    try {
      parameter = currentArgument.next();
      intValue = Integer.parseInt(parameter);
    } 
    catch (NoSuchElementException e) {
      throw new ArgsException(MISSING_INTEGER);
    } 
    catch (NumberFormatException e) {
      throw new ArgsException(INVALID_INTEGER, parameter);
    }
  }

  public boolean instanceIntegerArgument(ArgumentMarshaler am){
    if(am != null)
      if(am instanceof IntegerArgumentMarshaler)
        return true;
      else
        return false;
  }

  public static int getValue(ArgumentMarshaler am) {
    if (instanceIntegerArgument(am))
      return ((IntegerArgumentMarshaler) am).intValue;
    else
      return 0;
  }
}
