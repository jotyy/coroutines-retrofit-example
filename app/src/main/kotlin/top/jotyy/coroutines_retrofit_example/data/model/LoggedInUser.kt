package top.jotyy.coroutines_retrofit_example.data.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
        val userName: String,
        val nickName: String
)
