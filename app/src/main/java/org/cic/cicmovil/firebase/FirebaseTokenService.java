package org.cic.cicmovil.firebase;

/**
 * Created by PERSONAL on 01/04/2017.
 */

public class FirebaseTokenService {}//extends FirebaseMessagingService {
//    public static final String TAG = "FirebaseMsgService";
//    public static String message_id = "";
//
//    public FirebaseTokenService() {
//        super();
//    }
//
//    @Override
//    public void onMessageReceived(RemoteMessage remoteMessage) {
//        super.onMessageReceived(remoteMessage);
//
//        // TODO(developer): Handle FCM messages here.
//        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
//        Log.d(TAG, "From: " + remoteMessage.getFrom());
//
//        // Check if message contains a data payload.
//        if (remoteMessage.getData().size() > 0) {
//            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
//        }
//
//        // Check if message contains a notification payload.
//        if (remoteMessage.getNotification() != null) {
//            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
//        }
//
//        // Also if you intend on generating your own notifications as a result of a received FCM
//        // message, here is where that should be initiated. See sendNotification method below.
//        message_id = remoteMessage.getMessageId();
//
//        public_notification(remoteMessage.getData().get("message"));
//    }
//
//    @Override
//    public void onDeletedMessages() {
//        super.onDeletedMessages();
//    }
//
//    @Override
//    public void onMessageSent(String s) {
//        super.onMessageSent(s);
//    }
//
//    @Override
//    public void onSendError(String s, Exception e) {
//        super.onSendError(s, e);
//    }
//
//    public void public_notification(String message){
//        Uri default_sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        Intent intent = new Intent(this, MainActivity.class);
//        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext())
//                                            .setSmallIcon(R.mipmap.ic_launcher)
//                                            .setContentTitle(getString(R.string.app_name))
//                                            .setLights(Color.BLUE, 500, 500)
//                                            .setSound(default_sound)
//                                            .setContentText(message)
//                                            .setVibrate(new long[]{1000,500,1000})
//                                            .setContentIntent(pendingIntent);
//
//        notificationManager.notify(message_id, 1, builder.build());
//    }
//
//
//
//}
