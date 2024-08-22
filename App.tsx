// App.tsx
import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { Button, HostComponent, Text, View, requireNativeComponent } from 'react-native';
import { useRef } from 'react';

const CustomViewPager: HostComponent<any> =
  requireNativeComponent('CustomViewPager')


type RootStackParamList = {
  Home: undefined;
  Details: { itemId: number; otherParam?: string };
};

const Stack = createStackNavigator<RootStackParamList>();

function DashboardScreen({ navigation }) {
  const viewPagerRef = useRef<any>(null)

  return (
    <CustomViewPager style={{ flex: 1}} ref={viewPagerRef}>
      <HomeScreen1 />
      <HomeScreen2 />
      <HomeScreen3 />
      <HomeScreen4 />
      <HomeScreen5 />
    </CustomViewPager>
  );
}

function HomeScreen1() {
  return (
    <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
      <Text>Home Screen</Text>
      <Button
        title="Home1"
        onPress={() => {}}
      />
    </View>
  );
}

function HomeScreen2() {
  return (
    <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
      <Text>Home Screen</Text>
      <Button
        title="Home2"
        onPress={() => {}}
      />
    </View>
  );
}

function HomeScreen3() {
  return (
    <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
      <Text>Home Screen</Text>
      <Button
        title="Home2"
        onPress={() => {}}
      />
    </View>
  );
}

function HomeScreen4() {
  return (
    <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
      <Text>Home Screen</Text>
      <Button
        title="Home2"
        onPress={() => {}}
      />
    </View>
  );
}

function HomeScreen5() {
  return (
    <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
      <Text>Home Screen</Text>
      <Button
        title="Home2"
        onPress={() => {}}
      />
    </View>
  );
}

function DetailsScreen({ route, navigation }) {
  const { itemId, otherParam } = route.params;
  
  return (
    <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
      <Text>Details Screen</Text>
      <Text>Item ID: {itemId}</Text>
      <Text>Other Param: {otherParam}</Text>
      <Button title="Go back" onPress={() => navigation.goBack()} />
    </View>
  );
}

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Home">
        <Stack.Screen name="Details" component={DashboardScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
