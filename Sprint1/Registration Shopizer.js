describe('Test of Shopizer', function () {
    this.beforeAll('Open browser', function () {
        cy.visit('http://localhost:8080/')
    })
    
    it('As a customer of Shopizer I would like to be able to register myself on shopizer for better experience of shopping', function () {
        cy.contains('My Account').click({ force: true })
        cy.get('a[id="registerLink"]').contains('Register').click({ force: true })
        cy.get('input[id="firstName"]').type('AAART')
        cy.get('input[id="lastName"]').type('Redteam')
        cy.get('select[id="registration_country"]').select('Sweden').should('have.value', 'SE')
        cy.get('input[name="billing.stateProvince"]').type('Stockholm')
        cy.get('input[id="emailAddress"]').type('aaart.tester@yahoo.com')
        cy.get('input[id="password"]').type('finalproject2020')
        cy.get('input[id="passwordAgain"]').type('finalproject2020')
        cy.get('button').contains('Create an account').click()
        cy.contains('User with user name already exists for this store.').should('be.visible')
 
    })
 
    
})
