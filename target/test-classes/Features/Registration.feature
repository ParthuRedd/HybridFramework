Feature: User able to register and add product to cart



Scenario: Register and add product to cart
  When user click on register in landing page
	Then create account by entering emil address personal details
	| Fields                 | Values              |
  | First Name             | TestAutoma           |
  | Last Name              | Teating             |
  | Email Address          | AutomatTest@gmail.com   |
  | Address                | someoneAddress 23   |
  | City                   | Banglore            |
  | Reagion                | Badakhshan          |
  | ZIPCode                | 561522              |
  | LoginName              | CGTestin          |
  | Password               | Testing12@          |
  | ConfirmPassword        | Testing12@          |
  | Country                | Afghanistan         |
	And click register
	Then verify name and surname is displayed correct
	And add product to cart
	Then user proceed to checkout
	And verify on payment page is the product details are correct
	
