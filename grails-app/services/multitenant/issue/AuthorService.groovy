package multitenant.issue

import grails.compiler.GrailsCompileStatic
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.transactions.Transactional
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.query.Query
import org.hibernate.transform.Transformers
import org.springframework.beans.factory.annotation.Autowired

@CurrentTenant
@Transactional
@GrailsCompileStatic
class AuthorService {
	@Autowired
	SessionFactory sessionFactory

	def tenantNotHonored() {
		Query query = sessionFactory.currentSession.createQuery("select a.id as id from Author a") as Query
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
		query.list()
	}

	def tenantHonored() {
		Author.withSession { Session session ->
			Query query = session.createQuery("select a.id as id from Author a") as Query
			query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
			query.list()
		}
	}
}
