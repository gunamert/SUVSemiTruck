# SUVSemiTruck
implement a representation of an Eighteen Wheeler (Semi Truck). The Semi should be able to do the following on command:
1. Move Forward
2. Turn Right
3. Turn Left
4. Jack Knife to a Stop
Additionally, create a Traffic Control Device - specifically, a stop light. Given the appropriate command, this stop light has each of the following signals:
1. Green
2. Yellow
3. Red
4. Left-Turn Green
Rules:
1. If the Semi is already moving forward, the Move Forward command should generate an error
2. Only one signal in the traffic light can be on at a given time
3. The Semi can only turn left if the stop light's current signal is Left-Turn Green
4. After jack knifing to a stop, the Semi can only Move Forward
5. After each command to the Semi, the stop light's signal reverts back to Green

Continuing with your code with the Semi Truck, also implement a representation of an SUV that can:
1. Move Forward
2. Turn Right
3. Turn Left
4. Run Over Ford Pinto
Rules:
1. If the SUV is already moving forward, the Move Forward command should generate an error
2. The SUV can only turn left if the stop light's current signal is Left-Turn Green
3. After each command to the SUV, the stop light's signal reverts back to Green
4. The SUV can only Run Over Ford Pinto if its last action was to Move Forward
