package ru.akimov.messaging;

/**
 * @author akimov
 * created at 30.03.2020 11:43
 */
public interface Destinations {

	String SYNC_REQUEST_DEST = "akimov/sync_request_destination";

	String SYNC_RESPONSE_DEST = "akimov/sync_response_destination";

	String ASYNC_SEND_AND_FORGET_SERIAL_DEST = "akimov/async_send_and_forget_serial_dest";

	String ASYNC_SEND_AND_FORGET_PARALLEL_DEST = "akimov/async_send_and_forget_parallel_dest";

	String ASYNC_WITH_CALLBACK_SERIAL_DEST = "akimov/async_with_callback_serial_dest";
	String ASYNC_WITH_CALLBACK_PARALLEL_DEST = "akimov/async_with_callback_parallel_dest";
	String ASYNC_WITH_CALLBACK_CALLBACK_DEST = "akimov/async_with_callback_callback_dest";

	String DYNAMIC_DESTINATION = "akimov/dynamic_dest";

	String DESTINATION_TEMP = "akimov/tempdest";
}
