package com.hyon.oct131.error;

import java.util.List;

public interface ErrorMapper {
   public List<Error> getAllErrors();
   public List<Error> getSelectedErrors(Error error);
}
