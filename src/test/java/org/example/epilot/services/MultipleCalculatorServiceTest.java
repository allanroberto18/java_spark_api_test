package org.example.epilot.services;

import org.example.epilot.dto.ResultResponseDTO;
import org.example.epilot.exceptions.InvalidParameterException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MultipleCalculatorServiceTest {

  private MultipleCalculatorService multipleCalculatorService;
  private final ResultResponseDTO resultResponseDTO = mock(ResultResponseDTO.class);

  @BeforeEach
  void setUp() {
    multipleCalculatorService = new MultipleCalculatorService();
  }

  @Test
  public void calculateMultiple_WithMultipleOf7OnRequestParameter_MustReturnResponseDTOWithResultTrue() throws InvalidParameterException {
    when(resultResponseDTO.getResult()).thenReturn(true);

    ResultResponseDTO responseExpected = multipleCalculatorService.calculateMultiple(14, 7);

    Assertions.assertTrue(responseExpected.getResult());
  }

  @Test
  public void calculateMultiple_WithMultipleOf7OnRequestParameter_MustReturnResponseDTOWithResultFalse() throws InvalidParameterException {
    when(resultResponseDTO.getResult()).thenReturn(false);

    ResultResponseDTO responseExpected = multipleCalculatorService.calculateMultiple(13, 7);

    Assertions.assertFalse(responseExpected.getResult());
  }

  @Test
  public void calculateMultiple_WithMultipleOf5OnRequestParameter_MustReturnResponseDTOWithResultTrue() throws InvalidParameterException {
    when(resultResponseDTO.getResult()).thenReturn(true);

    ResultResponseDTO responseExpected = multipleCalculatorService.calculateMultiple(10, 5);

    Assertions.assertTrue(responseExpected.getResult());
  }

  @Test
  public void calculateMultiple_WithMultipleOfFive_MustReturnResponseDTOWithResultFalse() throws InvalidParameterException {
    when(resultResponseDTO.getResult()).thenReturn(false);

    ResultResponseDTO responseExpected = multipleCalculatorService.calculateMultiple(9, 5);

    Assertions.assertFalse(responseExpected.getResult());
  }

  @Test
  public void calculateMultiple_WithNullArgument_MustReturnInvalidParameterException() {
    Assertions.assertThrows(
        InvalidParameterException.class, () -> {
          multipleCalculatorService.calculateMultiple(null, 5);
        }
    );
  }
}
