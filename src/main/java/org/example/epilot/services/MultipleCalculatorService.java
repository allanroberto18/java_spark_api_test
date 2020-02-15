package org.example.epilot.services;

import org.example.epilot.dto.ResultResponseDTO;
import org.example.epilot.exceptions.InvalidParameterException;

public class MultipleCalculatorService {

  public MultipleCalculatorService() {}

  public ResultResponseDTO calculateMultiple(Integer number, Integer multiple) throws InvalidParameterException {
    if (number == null) {
      throw new InvalidParameterException("Number can't be nullable");
    }

    Integer result = number % multiple;

    return ResultResponseDTO
        .builder()
        .result(result.equals(0))
        .build();
  }
}
