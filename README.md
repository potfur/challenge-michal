# Backend challenge
Thank you very much for investing your time in the recruitment process of Cardino. We hope that you will find this one an interesting way to spend a couple of hours.

## Help needed!
We want to create an REST API for ingesting Car data. But so far we have only got a rough API draft and some pseudo code.
Most of our services are built using Spring Boot and Kotlin. You will find a Spring Boot project in this repository. Feel free to use it or start from scratch.

##Features
1. Create a car
   - Output: CarDto
2. Get a car by its ID
   - Output: CarDto
3. Get the total value of cars created the current month by a customer ID
   - Output: MonthReportDto

### Type definitions
Our colleague drafted the following Entity definitions. As he did not know what technology we might use in the end these are GraphQl definitions. He told us though that properties marked with an exclamation mark (!) are required.

```graphql
type Customer {
   id: ID!
   name: String!
}

type Car {
   id: ID!
   brand: String!
   model: String!
   firstRegistration: String!
   customer: Customer!
   equipment: [Equipment!]!
   sellingPrice: Float!
}

type Equipment {
    name: String!
    value: String!
}
```

## Good to know
You can use any frameworks you want. You can use any libraries you want. Commit all changes to a Git repository and follow good commit message practice. Focus on good application structure, not a hacky solution.

# It's not about the goal but about the journey, show us what you have got!
