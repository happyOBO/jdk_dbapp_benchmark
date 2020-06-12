package mymusictray.model;

import mymusictray.exception.ModelMisuseException;


/**
 * Data Structure that has insert, update, and remove operation
 *
 * @author Prev (0soo.2@prev.kr)
 */
public interface Model {

	/**
	 * Insert current model to database
	 *
	 * @throws ModelMisuseException when you try already inserted model
	 */
	void insert();


	/**
	 * Update current model to database
	 *
	 * @throws ModelMisuseException when you try to update model that is not in database yet
	 */
	void update();


	/**
	 * Remove current model from database
	 *
	 * @throws ModelMisuseException when you try to remove model that is not in database yet
	 */
	void remove();
}
