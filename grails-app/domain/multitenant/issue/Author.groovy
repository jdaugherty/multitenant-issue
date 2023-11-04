package multitenant.issue

import grails.gorm.MultiTenant

class Author implements MultiTenant<Author> {
	String name
	String tenantId

	static mapping = {
		tenantId name:'tenantId'
	}
}
