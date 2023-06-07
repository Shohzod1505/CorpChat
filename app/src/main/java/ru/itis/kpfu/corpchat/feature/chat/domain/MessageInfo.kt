package ru.itis.kpfu.corpchat.feature.chat.domain

data class MessageInfo(
    val messageId: String,
    val senderId: String,
    val receiveId: String,
    val message: String,
) {
  constructor() : this(
      messageId = "",
      senderId = "",
      receiveId = "",
      message = "",
  )
}
