CREATE AGGREGATE array_agg_arrays(anyarray)
	(
	SFUNC = array_cat,
	STYPE = anyarray
	);