# java-katas

### Implementation for the [katas](http://codekata.com/kata/) 

- [kata16-business-rules/](http://codekata.com/kata/kata16-business-rules)

- I have implemented the kata 16 that and added the tests in order to verify the expected result. 

- I think that there are many ways to implement those rules but the thing that needs to be kept in mind is the SOLID principles. Specially the Open/Close principle in order to reduce possible impact on the changes.

### Things that should be improved with a bit more time: 
- Covers with unit tests the whole application.
- Make clear the responsibilities between the payment service and the order service. I think that it may be unclear where are the boundaries with OrderService and PaymentService. 
- Improve the design of the Product models but in a way that respects the substitution principle.