package org.example.epilot;

import org.example.epilot.exceptions.InvalidParameterException;
import org.example.epilot.services.MultipleCalculatorService;
import org.example.epilot.transformer.JsonTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.*;

public class MainApplication {

  private static final Logger log = LoggerFactory.getLogger(MainApplication.class);

  public static void main(String[] args) {
    MultipleCalculatorService service = new MultipleCalculatorService();

    port(4567);

    post("/baz/:number", (req, res) -> {
      Integer number = Integer.parseInt(req.params("number"));

      return service.calculateMultiple(number, 7);
    }, new JsonTransformer());

    post("/fiz/:number", (req, res) -> {
      Integer number = Integer.parseInt(req.params("number"));

      return service.calculateMultiple(number, 5);
    }, new JsonTransformer());

    notFound((req, res) -> {
      res.type("application/json");
      return "{\"message\":\"Result not found, check your request\"}";
    });

    get("/throwexception", (request, response) -> {
      throw new NumberFormatException("The parameter can't be parsed to Integer");
    });

    exception(NumberFormatException.class, (exception, request, response) -> {
      log.error(exception.getMessage());
    });
  }
}
