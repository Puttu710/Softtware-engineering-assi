package com.cleancoder.args;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

import java.util.*;

public class StringArrayArgumentMarshaler implements ArgumentMarshaler {
  private List<String> strings = new ArrayList<String>();

  public void set(Iterator<String> currentArgument) throws ArgsException {
    try {
      strings.add(currentArgument.next());
    } catch (NoSuchElementException e) {
      throw new ArgsException(MISSING_STRING);
    }
  }
  private boolean CheckStringArrayArgumentMarshaler(ArgumentMarshaler am){
    return (am!=null && am instanceof StringArrayArgumentMarshaler);
   }

  public static String[] getValue(ArgumentMarshaler am) {
    if (CheckStringArrayArgumentMarshaler(am))
      return ((StringArrayArgumentMarshaler) am).strings.toArray(new String[0]);
    else
      return new String[0];
  }
}
