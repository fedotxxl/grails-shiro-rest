class ShiroRestFilters {

    def filters = {
        all(uri: "/rest/**") {
            before = {
                if (!(controllerName == 'office' && actionName == 'hall')) {
                    accessControl()
                }
            }
        }
    }

    def onUnauthorized(subject, d) {
        d.render status: 401, text:"Permission Denied"
    }

}
