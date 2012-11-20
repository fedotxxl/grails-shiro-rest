class UrlMappings {

	static mappings = {
		"/$action?" (controller: 'office')
		"/"(controller: 'office', action: 'hall')
		"500"(view:'/error')

        // auth controller
        "/auth/$action?" (controller: 'auth')

        // REST api
        "/rest/$action" (controller: 'office')
        "/rest/" (controller: 'office', action: 'hall')

    }
}
