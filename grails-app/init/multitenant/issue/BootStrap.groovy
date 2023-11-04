package multitenant.issue

import grails.gorm.multitenancy.WithoutTenant
import grails.gorm.transactions.Transactional

@WithoutTenant
class BootStrap {

	def init = { servletContext ->
		log.info("Creating Authors")
		createAuthors()

	}

	@Transactional
	void createAuthors() {
		Author author1 = new Author(name: 'FOO', tenantId: 'TESTING')
		author1.save()

		Author author2 = new Author(name: 'FOO', tenantId: 'OTHER')
		author2.save()
	}
}
