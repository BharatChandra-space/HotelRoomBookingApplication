# HotelRoomBookingApplication
We book a room through the booking Service(saving the details in database) and the booking service would talk to payment service((saving the details in database) to return a dummy TransactionID. This TransactionID is updated in the Booking Service table. After the successful transaction, the booking service would send a notification to one of my pre configured Kafka publisher topics. And my notification Service would consume this to perform dummy action. This is just a framework of a clear Entity.
