class UrlMappings {

	static mappings = {
		"/$action?" (controller: 'office')
		"/"(controller: 'office', action: 'hall')
		"500"(view:'/error')
	}
}
