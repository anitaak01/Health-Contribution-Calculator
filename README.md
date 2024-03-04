Health Contribution Calculator - The calculator is a web-based application for managing data related to health contribution calculations. 
The user records data such as revenue, expenses, deductions in the database. Based on these, the application calculates the income for the company, 
and then the basis of the health contribution, as well as the contribution itself. Thymeleaf, Spring Security, Spring Data JPA, HTML were used to create it.

User Manual

Companies page
/company/list: Displays a list of all companies.
/company/showFormForAdd: Displays a form to add a new company.
/company/showFormForUpdate?companyId={id}: Displays a form to edit an existing company.
/company/delete?companyId={id}: Deletes a company based on its ID.

Deduction page
/deduction/list: Displays a list of deductions for a given company.
/deduction/showFormForAdd: Displays a form to add a new deduction.
/deduction/showFormForUpdate?deductionId={id}: Displays a form to edit an existing deduction.
/deduction/delete?deductionId={id}: Deletes a deduction based on its ID.

Health contribution bases page
/healthContributionBase/list: Displays a list of health contribution bases for a given company.
/healthContributionBase/showFormForAdd: Displays a form for adding a new health contribution base.
/healthContributionBase/delete?healthContributionBaseId={id}: Deletes a health contribution base based on its ID.

Health Contribution Page
/healthContribution/list: Displays a list of health contributions for a particular company.
/healthContribution/showFormForAdd: Displays a form to add a new health contribution.
/healthContribution/delete?healthContributionId={id}: Deletes a health contribution based on its ID.

Income page
/income/list: Displays a list of income for a given company.
/income/showFormForAdd: Displays a form for adding new income.
/income/showFormForUpdate?id={id}: Displays a form to edit an existing income.
/income/delete?id={id}: Deletes an income based on its ID.
