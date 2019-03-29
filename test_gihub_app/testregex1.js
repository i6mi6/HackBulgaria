import { connect } from 'react-redux'
import React from 'react'
import {
  StyleSheet,
  Image,
  View,
  Dimensions,
  FlatList,
} from 'react-native'
import {
  Text,
  Button,
  Card,
  CardItem,
  H2,
  Container,
  Content,
} from 'native-base'
import _ from 'lodash'
import Loading from '../../components/common/Loading'
import { setStoreConnectionId, setStoreImapiConnectionId, waitingForStore } from './Actions'
import StoreConnectionStatus from '../../components/stores/StoreConnectionStatus'
import SimpleHeader from '../../components/common/SimpleHeader'
import {
  openModal,
  closeModal,
} from '../../actions'
import { ThemeButton } from '../../components/common'
import { withStoreConnections } from '../../gqlOperations/stores'
import { compose } from 'recompose'
import { getCurrentOnboardingStatus } from '../../sagas/onboarding'

const { width, height } = Dimensions.get('window')

class StoreListContainer extends React.Component {
  state = {
    checkingConnection: false,
    statusMessage: '',
    alertMessage: '',
    connectionId: '',
  }

  handleClick = storeConnection => {
    if (storeConnection.node.credentialsStatus === 'Waiting') {
      this.props.navigation.navigate('ConnectStoreContainer', {
        store: {
          name: storeConnection.node.store.name,
          storeConnectionId: storeConnection.node.id,
          imapiConnectionId: storeConnection.node.connectionId,
          id: storeConnection.node.store.id,
          imageLink: storeConnection.node.store.imageLink,
        },
        updatingConnection: false,
      })
    }

    else if (storeConnection.node.credentialsStatus === 'Cant Connect') {

      this.props.openModal({
        content: (
          <View style={styles.container}>
            <View style={{ flex: 1 }} />
            <View style={styles.innerContainer}>
              <H2 style={{ marginBottom: 10, textAlign: 'center' }}>Cooklist is not able to connect to {storeConnection.node.store.name} yet</H2>
              <Text style={{ marginBottom: 10 }}>{`We are working to develop integrations with new stores and will let you know when it's possible to connect with this store.

Until then, you can import purchases from this store into your pantry with the barcode scanner or by clicking the green + button in the pantry.`}</Text>
              <ThemeButton text='Ok' onPress={() => this.props.closeModal()} />
            </View>
          </View>),
        modalProps: { style: { marginTop: 0 } },
      })
    }
    else {
      this.props.setStoreConnectionId(storeConnection.node.id)
      this.props.setStoreImapiConnectionId(storeConnection.node.connectionId)
      this.props.waitingForStore(true)
      this.props.navigation.navigate('StoreSettingsContainer', { storeConnection })
    }

  }

  keyExtractor = (item) => item.node.id

  renderItem = ({ item }) => (
    <StoreListItem
      storeConnection={item}
      onPress={this.handleClick} />
  )

  renderListHeader = () => {
    const { navigation } = this.props
    const onboarding = _.get(navigation, 'state.params.onboarding', false)
    const status = getCurrentOnboardingStatus()
    if (onboarding || !status.storeConnection) {
      return (
        <Text style={styles.subtitle}>
          Choose one of the available stores{'\n'}below to connect it to Cooklist
        </Text>
      )
    }
    return null
  }

  onAddStore = () => this.props.navigation.navigate('SearchStoreContainer')

  render() {
    const { loading } = this.props.data
    if (loading) {
      return (
        <Container>
          <Content white>
            <Card nomargin transparent>
              <CardItem column style={{ marginTop: 200 }}>
                <Loading />
              </CardItem>
            </Card>
          </Content>
        </Container>
      )
    }
    if (this.props.data.error) {
      return alert('No Internet connection')
    }
    return (
      <Container>
        <SimpleHeader
          title='Stores'
          right={
            <Button transparent onPress={this.onAddStore}>
              <Image
                source={require('../../../assets/icons/add_store_green.png')}
                style={{ width: 30 }}
                resizeMode='contain'
              />
            </Button>
          } />
        <FlatList
          ListHeaderComponent={this.renderListHeader()}
          keyExtractor={this.keyExtractor}
          renderItem={this.renderItem}
          data={storeConnections} />
      </Container>
    )
  }
}

class StoreListItem extends React.Component {

  onPress = () => {
    const { storeConnection } = this.props
    this.props.onPress(storeConnection)
  }

  renderStoreError = () => {
    const { storeConnection } = this.props
    const credentialsStatus = storeConnection.node.credentialsStatus
    if (credentialsStatus === 'Exception' || credentialsStatus === 'Invalid') {
      return (
        <Text style={styles.errorStoreText}>
          Error trying to connect. Please check.
        </Text>
      )
    }
  }

  render() {
    const { storeConnection } = this.props
    return (
      <Card
        transparent
        key={storeConnection.node.id}
        style={styles.storeCard}> 
        <CardItem
          button
          wideRow
          onPress={this.onPress}
          style={styles.cardItem}>
          <CardItem style={{ paddingTop: 0, paddingBottom: 0, paddingLeft: 0, paddingRight: 0 }}>
            <Image
              resizeMode='contain'
              style={styles.storeLogo}
              source={{ uri: storeConnection.node.store.imageLink }} />
            <View style={{ flex: 1 }}>
              <H2 style={styles.title}>{storeConnection.node.store.name}</H2>
              {this.renderStoreError()}
            </View>
            <StoreConnectionStatus
              credentialsStatus={storeConnection.node.credentialsStatus} />
          </CardItem>
        </CardItem>
      </Card>
    )
  }
}

export default compose(  
  connect(null, { 
    setStoreConnectionId,
    setStoreImapiConnectionId,
    waitingForStore, 
    openModal,
    closeModal, 
  }),
  withStoreConnections,
)(StoreListContainer)

const styles = StyleSheet.create({
  container: {
    width,
    height,
  },
  innerContainer: {
    flex: 0.8,
    backgroundColor: "#fff",
    borderRadius: 6,
    padding: 20,
  },
  subtitle: {
    textAlign: 'center',
    marginTop: 10,
    color: '#333333',
    fontFamily: 'Lato',
    fontSize: 14,
  },
  errorStoreText: {
    marginLeft: 20,
    color: '#F70044',
    fontFamily: 'Lato',
    fontSize: 14,
  },
  icon: {
    color: 'white',
  },
  button: {
    marginTop: 20,
    justifyContent: 'center',
  },
  header: {
    flex: 0.15,
  },
  storeLogo: {
    width: 70,
    height: 50,
  },
  logoCard: {
    flex: 0.5,
    height: 50,
  },
  title: {
    marginLeft: 20,
    fontFamily: 'Lato-Semibold',
    fontSize: 16,
    maxWidth: 150,
  },
  cardItem: {
    paddingTop: 20,
    paddingBottom: 20,
  },
  storeCard: {
    borderBottomWidth: 1,
    borderBottomColor: '#E9EFFB',
  },
  storeImage: {
    width: 300,
    height: 200,
    marginBottom: 30,
    marginTop: 20,
  },
  modalContent: {
    backgroundColor: 'white',
    padding: 22,
    justifyContent: 'center',
    alignItems: 'center',
    borderRadius: 4,
    borderColor: 'rgba(0, 0, 0, 0.1)',
    marginTop: 300,
    marginBottom: 0,
    marginRight: 0,
    marginLeft: 0,
  },
})
