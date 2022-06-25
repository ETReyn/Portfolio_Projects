Start Transaction;

Drop Table If Exists happiness;

Create Table happiness(

    id serial,
    country_name varchar(50),
    total_score numeric(5,3), 
    dystopia numeric(5,3), 
    residual numeric(5,3), 
    gdp numeric(5,3), 
    corruption numeric(5,3), 
    life_expectancy numeric(5,3), 
    social_support numeric(5,3), 
    generosity numeric(5,3), 
    personal_autonomy numeric(5,3),

    Constraint pk_happiness Primary Key(id)

);

Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Finland', 7.756, 2.518, 1.892, 1.258, 0.775, 0.736, 0.109, 0.534);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Denmark', 7.563, 2.226, 1.953, 1.243, 0.777, 0.719, 0.188, 0.532);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Iceland', 7.464, 2.320, 1.936, 1.320, 0.803, 0.718, 0.270, 0.191);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Switzerland', 7.437, 2.153, 2.026, 1.226, 0.822, 0.677, 0.147, 0.461);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Netherlands', 7.359, 2.137, 1.945, 1.206, 0.787, 0.651, 0.271, 0.419);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Luxembourg*', 7.307, 2.042, 2.209, 1.155, 0.790, 0.700, 0.120, 0.388);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Sweden', 7.315, 2.003, 1.920, 1.204, 0.803, 0.724, 0.218, 0.512);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Norway', 7.290, 1.925, 1.997, 1.239, 0.786, 0.728, 0.217, 0.474);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Israel', 7.301, 2.634, 1.826, 1.221, 0.818, 0.568, 0.155, 0.143);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('New Zealand', 7.120, 1.954, 1.852, 1.235, 0.752, 0.680, 0.245, 0.483);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Austria', 7.089, 2.148, 1.931, 1.165, 0.774, 0.623, 0.193, 0.329);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Australia', 7.081, 2.011, 1.900, 1.203, 0.772, 0.676, 0.258, 0.341);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Ireland', 6.961, 1.743, 2.129, 1.166, 0.779, 0.627, 0.190, 0.408);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Germany', 6.947, 2.142, 1.924, 1.088, 0.776, 0.585, 0.163, 0.358);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Canada', 6.943, 1.924, 1.886, 1.188, 0.783, 0.659, 0.217, 0.368);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('United States', 6.888, 2.214, 1.982, 1.182, 0.628, 0.574, 0.220, 0.177);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('United Kingdom', 6.867, 1.967, 1.867, 1.143, 0.750, 0.597, 0.289, 0.329);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Czechia', 6.811, 2.263, 1.815, 1.260, 0.715, 0.660, 0.158, 0.048);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Belgium', 6.720, 2.283, 1.907, 1.106, 0.764, 0.492, 0.049, 0.204);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('France', 6.615, 1.895, 1.863, 1.219, 0.808, 0.567, 0.070, 0.266);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Bahrain', 6.514, 2.092, 1.854, 1.029, 0.625, 0.693, 0.199, 0.155);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Slovenia', 6.542, 1.885, 1.810, 1.249, 0.769, 0.685, 0.118, 0.115);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Costa Rica', 6.481, 2.346, 1.584, 1.054, 0.744, 0.661, 0.089, 0.102);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('United Arab Emirates', 6.492, 1.809, 1.998, 0.980, 0.633, 0.702, 0.204, 0.250);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Saudi Arabia', 6.409, 2.075, 1.870, 1.092, 0.577, 0.651, 0.078, 0.180);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Taiwan Province of China', 6.429, 2.002, 1.897, 1.095, 0.733, 0.542, 0.075, 0.168);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Singapore', 6.392, 0.932, 2.149, 1.127, 0.851, 0.672, 0.163, 0.587);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Romania', 6.379, 2.446, 1.719, 1.006, 0.655, 0.605, 0.039, 0.006);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Spain', 6.392, 1.893, 1.808, 1.211, 0.808, 0.505, 0.101, 0.149);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Uruguay', 6.386, 1.974, 1.615, 1.180, 0.672, 0.665, 0.103, 0.265);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Italy', 6.363, 2.222, 1.834, 1.052, 0.801, 0.412, 0.085, 0.059);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Kosovo', 6.339, 2.631, 1.362, 0.949, 0.569, 0.599, 0.309, 0.035);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Malta', 6.359, 1.631, 1.838, 1.169, 0.789, 0.679, 0.174, 0.166);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Lithuania', 6.356, 2.153, 1.804, 1.204, 0.659, 0.496, 0.053, 0.077);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Slovakia', 6.306, 2.094, 1.736, 1.232, 0.707, 0.479, 0.118, 0.025);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Estonia', 6.266, 1.442, 1.793, 1.232, 0.728, 0.689, 0.123, 0.333);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Panama', 6.154, 2.086, 1.715, 1.107, 0.709, 0.592, 0.049, 0.051);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Brazil', 6.202, 2.361, 1.462, 1.044, 0.615, 0.546, 0.131, 0.134);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Guatemala*', 6.064, 2.746, 1.274, 0.831, 0.522, 0.662, 0.112, 0.115);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Kazakhstan', 6.138, 1.860, 1.668, 1.220, 0.611, 0.584, 0.134, 0.157);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Cyprus', 6.122, 2.044, 1.815, 0.909, 0.819, 0.448, 0.123, 0.062);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Latvia', 6.106, 1.923, 1.732, 1.221, 0.637, 0.502, 0.075, 0.090);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Serbia', 6.062, 2.031, 1.550, 1.086, 0.658, 0.546, 0.219, 0.088);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Chile', 6.082, 2.040, 1.651, 1.080, 0.748, 0.460, 0.124, 0.069);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Nicaragua', 6.017, 2.418, 1.105, 1.029, 0.617, 0.617, 0.168, 0.212);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Mexico', 6.017, 2.239, 1.552, 0.886, 0.623, 0.621, 0.092, 0.115);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Croatia', 6.022, 1.884, 1.705, 1.183, 0.709, 0.535, 0.109, 0.000);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Poland', 6.040, 1.693, 1.758, 1.174, 0.712, 0.523, 0.124, 0.140);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('El Salvador', 5.990, 2.514, 1.265, 0.768, 0.607, 0.666, 0.089, 0.212);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Kuwait*', 5.977, 1.621, 1.904, 0.983, 0.747, 0.617, 0.087, 0.147);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Hungary', 5.985, 1.812, 1.748, 1.233, 0.668, 0.485, 0.078, 0.064);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Mauritius', 5.958, 1.969, 1.591, 1.116, 0.568, 0.589, 0.131, 0.107);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Uzbekistan', 5.948, 1.913, 1.219, 1.092, 0.600, 0.716, 0.283, 0.240);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Japan', 5.959, 1.487, 1.835, 1.089, 0.866, 0.537, 0.007, 0.218);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Honduras', 5.855, 2.611, 1.111, 0.885, 0.555, 0.582, 0.202, 0.076);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Portugal', 5.911, 1.691, 1.760, 1.078, 0.777, 0.655, 0.016, 0.039);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Argentina', 5.844, 1.891, 1.592, 1.102, 0.662, 0.555, 0.081, 0.085);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Greece', 5.853, 2.119, 1.703, 0.980, 0.774, 0.249, 0.015, 0.108);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('South Korea', 5.849, 1.656, 1.851, 0.886, 0.841, 0.414, 0.111, 0.176);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Philippines', 5.800, 2.283, 1.268, 0.912, 0.514, 0.678, 0.107, 0.142);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Thailand', 5.788, 1.600, 1.535, 1.096, 0.697, 0.617, 0.321, 0.026);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Moldova', 5.766, 2.142, 1.417, 1.008, 0.597, 0.561, 0.102, 0.028);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Jamaica', 5.676, 2.164, 1.296, 1.045, 0.646, 0.567, 0.080, 0.053);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Kyrgyzstan', 5.741, 2.087, 1.069, 1.109, 0.638, 0.693, 0.208, 0.025);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Belarus*', 5.693, 1.811, 1.562, 1.157, 0.629, 0.342, 0.040, 0.282);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Colombia', 5.659, 1.971, 1.452, 0.929, 0.720, 0.545, 0.087, 0.077);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Bosnia and Herzegovina', 5.659, 1.869, 1.468, 1.068, 0.665, 0.448, 0.244, 0.006);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Mongolia', 5.676, 1.999, 1.393, 1.197, 0.467, 0.398, 0.247, 0.059);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Dominican Republic', 5.601, 1.751, 1.538, 1.003, 0.577, 0.606, 0.084, 0.179);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Malaysia', 5.578, 1.471, 1.689, 0.938, 0.620, 0.654, 0.213, 0.126);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Bolivia', 5.491, 2.107, 1.256, 0.880, 0.555, 0.627, 0.112, 0.064);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('China', 5.520, 1.516, 1.508, 0.958, 0.705, 0.656, 0.099, 0.142);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Paraguay', 5.467, 1.555, 1.409, 1.130, 0.624, 0.629, 0.171, 0.059);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Peru', 5.439, 1.890, 1.397, 0.865, 0.735, 0.545, 0.090, 0.037);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Montenegro', 5.413, 1.619, 1.573, 1.023, 0.659, 0.460, 0.135, 0.077);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Ecuador', 5.414, 1.866, 1.352, 0.879, 0.708, 0.565, 0.080, 0.083);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Vietnam', 5.400, 1.735, 1.252, 0.932, 0.611, 0.707, 0.143, 0.105);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Turkmenistan*', 5.371, 1.160, 1.484, 1.319, 0.516, 0.649, 0.314, 0.032);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('North Cyprus*', 5.325, 1.078, 1.815, 0.888, 0.819, 0.523, 0.130, 0.213);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Russia', 5.392, 1.494, 1.685, 1.095, 0.586, 0.401, 0.117, 0.080);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Hong Kong S.A.R. of China', 5.348, 0.642, 1.957, 0.954, 0.942, 0.400, 0.147, 0.383);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Armenia', 5.278, 1.654, 1.434, 0.820, 0.668, 0.558, 0.054, 0.210);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Tajikistan', 5.287, 1.895, 0.966, 1.005, 0.518, 0.572, 0.118, 0.304);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Nepal', 5.251, 2.224, 0.984, 0.784, 0.499, 0.519, 0.237, 0.130);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Bulgaria', 5.257, 1.235, 1.625, 1.163, 0.640, 0.563, 0.123, 0.021);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Libya*', 5.118, 1.544, 1.476, 0.943, 0.606, 0.477, 0.106, 0.179);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Indonesia', 5.139, 1.300, 1.382, 0.883, 0.539, 0.620, 0.468, 0.047);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Ivory Coast', 5.085, 2.652, 1.094, 0.442, 0.322, 0.451, 0.149, 0.124);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('North Macedonia', 5.095, 1.461, 1.505, 0.863, 0.637, 0.488, 0.215, 0.031);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Albania', 5.076, 1.718, 1.439, 0.646, 0.719, 0.511, 0.138, 0.028);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('South Africa', 5.073, 1.742, 1.425, 1.088, 0.361, 0.442, 0.089, 0.046);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Azerbaijan*', 5.082, 1.098, 1.458, 1.093, 0.560, 0.601, 0.023, 0.341);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Gambia*', 4.918, 2.531, 0.785, 0.621, 0.369, 0.367, 0.388, 0.103);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Bangladesh', 5.049, 1.967, 1.060, 0.614, 0.581, 0.622, 0.125, 0.187);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Laos', 5.018, 1.709, 1.239, 0.654, 0.479, 0.679, 0.197, 0.184);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Algeria', 5.030, 1.744, 1.363, 0.970, 0.643, 0.146, 0.106, 0.150);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Liberia*', 4.815, 2.844, 0.636, 0.670, 0.309, 0.405, 0.178, 0.080);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Ukraine', 4.978, 1.331, 1.411, 1.081, 0.583, 0.473, 0.188, 0.017);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Congo', 4.915, 2.658, 0.950, 0.405, 0.355, 0.431, 0.130, 0.146);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Morocco', 4.938, 2.405, 1.208, 0.268, 0.565, 0.492, 0.020, 0.102);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Mozambique', 4.823, 2.641, 0.578, 0.660, 0.191, 0.593, 0.185, 0.200);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Cameroon', 4.907, 2.469, 0.968, 0.672, 0.317, 0.397, 0.152, 0.074);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Senegal', 4.921, 2.419, 0.933, 0.530, 0.447, 0.494, 0.143, 0.081);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Niger*', 4.760, 2.667, 0.570, 0.560, 0.326, 0.571, 0.165, 0.145);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Georgia', 4.867, 1.583, 1.467, 0.612, 0.595, 0.508, 0.000, 0.208);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Gabon', 4.826, 1.892, 1.459, 0.738, 0.396, 0.343, 0.032, 0.099);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Iraq', 4.783, 1.894, 1.289, 0.682, 0.554, 0.328, 0.147, 0.046);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Venezuela', 4.800, 2.790, 0.000, 0.968, 0.578, 0.283, 0.225, 0.082);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Guinea', 4.753, 2.538, 0.848, 0.566, 0.275, 0.334, 0.214, 0.116);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Iran', 4.780, 1.427, 1.410, 0.741, 0.642, 0.281, 0.241, 0.146);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Ghana', 4.745, 1.972, 1.112, 0.595, 0.409, 0.500, 0.230, 0.056);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Turkey', 4.644, 1.059, 1.707, 0.865, 0.702, 0.209, 0.087, 0.115);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Burkina Faso', 4.527, 2.313, 0.779, 0.565, 0.320, 0.382, 0.186, 0.126);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Cambodia', 4.516, 1.410, 1.019, 0.732, 0.505, 0.740, 0.166, 0.068);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Benin', 4.492, 2.458, 0.932, 0.064, 0.335, 0.479, 0.127, 0.230);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Comoros*', 4.368, 2.304, 0.899, 0.476, 0.424, 0.185, 0.195, 0.125);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Uganda', 4.459, 1.842, 0.777, 0.875, 0.418, 0.402, 0.222, 0.066);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Nigeria', 4.453, 1.784, 1.079, 0.732, 0.300, 0.444, 0.175, 0.038);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Kenya', 4.403, 1.661, 1.032, 0.605, 0.401, 0.440, 0.322, 0.082);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Tunisia', 4.403, 1.540, 1.350, 0.596, 0.656, 0.316, 0.029, 0.029);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Pakistan', 4.397, 1.940, 1.049, 0.413, 0.374, 0.448, 0.181, 0.112);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Palestinian Territories*', 4.300, 1.368, 1.148, 0.957, 0.521, 0.336, 0.073, 0.079);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Mali', 4.347, 2.373, 0.792, 0.483, 0.311, 0.350, 0.128, 0.042);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Namibia', 4.326, 1.414, 1.292, 0.877, 0.354, 0.384, 0.067, 0.071);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('"Eswatini', 4.396, 1.688, 1.274, 0.786, 0.197, 0.259, 0.038, 0.154);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Myanmar', 4.277, 0.877, 1.038, 0.829, 0.491, 0.513, 0.452, 0.194);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Sri Lanka', 4.237, 0.595, 1.415, 0.934, 0.660, 0.529, 0.150, 0.079);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Madagascar*', 4.148, 2.148, 0.670, 0.645, 0.378, 0.202, 0.143, 0.154);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Egypt', 4.198, 0.856, 1.388, 0.732, 0.548, 0.469, 0.041, 0.254);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Chad*', 3.999, 2.419, 0.662, 0.506, 0.225, 0.180, 0.182, 0.077);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Ethiopia', 4.118, 1.375, 0.788, 0.809, 0.457, 0.472, 0.205, 0.136);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Yemen*', 4.010, 1.561, 0.691, 1.043, 0.384, 0.330, 0.090, 0.098);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Mauritania*', 3.950, 1.207, 1.100, 0.865, 0.450, 0.304, 0.088, 0.138);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Jordan', 4.029, 0.695, 1.324, 0.724, 0.675, 0.476, 0.058, 0.200);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Togo', 3.953, 2.061, 0.771, 0.322, 0.360, 0.292, 0.174, 0.132);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('India', 3.726, 0.795, 1.167, 0.376, 0.471, 0.647, 0.198, 0.123);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Zambia', 3.618, 1.135, 0.930, 0.577, 0.306, 0.525, 0.203, 0.083);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Malawi', 3.560, 1.661, 0.648, 0.279, 0.388, 0.477, 0.140, 0.157);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Tanzania', 3.558, 0.735, 0.848, 0.597, 0.425, 0.578, 0.248, 0.270);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Sierra Leone', 3.416, 1.556, 0.686, 0.416, 0.273, 0.387, 0.202, 0.055);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Lesotho*', 3.276, 1.312, 0.839, 0.848, 0.000, 0.419, 0.076, 0.018);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Botswana*', 3.275, 0.187, 1.503, 0.815, 0.280, 0.571, 0.012, 0.102);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Rwanda*', 3.074, 0.536, 0.785, 0.133, 0.462, 0.621, 0.187, 0.544);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Zimbabwe', 2.880, 0.548, 0.947, 0.690, 0.270, 0.329, 0.106, 0.105);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Lebanon', 2.862, 0.216, 1.392, 0.498, 0.631, 0.103, 0.082, 0.034);
Insert Into happiness (country_name, total_score, dystopia, gdp, social_support, life_expectancy, personal_autonomy, generosity, corruption) Values('Afghanistan', 2.339, 1.263, 0.758, 0.000, 0.289, 0.000, 0.089, 0.005);

commit;